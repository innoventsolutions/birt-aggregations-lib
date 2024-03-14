package org.eclipse.birt.engine;

import java.util.logging.Level;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;

public class ReportEngine {
	private static IReportEngine reportEngine;
	public static final String RESOURCE_DIR;

	static {
		/*
		 * final URL url = ReportEngine.class.getResource(".");
		 * System.out.println("ReportEngine static url = " + url); Pattern pattern =
		 * Pattern.compile("file:(.*)/reports"); Matcher matcher =
		 * pattern.matcher(url.toString()); if (!matcher.matches()) { throw new
		 * IllegalStateException(); } String resourceDirName = matcher.group(1); if
		 * (resourceDirName == null) throw new NullPointerException(
		 * "property: org.eclipse.birt.rip.resource.dir");
		 * System.out.println("ReportEngine static resource dir = " + resourceDirName);
		 * RESOURCE_DIR = resourceDirName;
		 */
		RESOURCE_DIR = "/disk1/home/innovent/projects/birt-aggregations-lib/birt.aggregations.lib.test/src/test/resources";
		System.out.println("RESOURCE_DIR = " + RESOURCE_DIR);
	}

//	@SuppressWarnings("unchecked")
	public static IReportEngine getReportEngine() throws BirtException {
		if (reportEngine != null) {
			return reportEngine;
		}
		final EngineConfig config = new EngineConfig();
		config.setLogConfig(RESOURCE_DIR + "/logs", Level.WARNING);
		config.setResourcePath(RESOURCE_DIR);
		System.out.println("ReportEngine getReportEngine() BIRTHome = " + config.getBIRTHome());
		config.setProperty(EngineConstants.WEBAPP_CLASSPATH_KEY, RESOURCE_DIR);
//		ClassLoader classLoader = ReportEngine.class.getClassLoader();
//		System.out.println("ReportEngine getReportEngine() classLoader = " + classLoader);
//		config.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY,
//				classLoader);
		Platform.startup(config);
		final IReportEngineFactory factory = (IReportEngineFactory) Platform
				.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		reportEngine = factory.createReportEngine(config);
		return reportEngine;
	}
}
