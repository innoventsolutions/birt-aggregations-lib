/**
 * Copyright (c) 2008-Present  Innovent Solutions, Inc.
 *
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Scott Rosenbaum - Innovent Solutions
 *  Steve Schafer - Innovent Solutions
 *
 */
package innovent.birt.aggregations;

import org.eclipse.birt.core.data.DataType;
import org.eclipse.birt.data.aggregation.impl.TotalMovingAve;

/**
 * Implements a decimal sum.
 *
 */
@SuppressWarnings("restriction")
public class DecimalMovingAve extends TotalMovingAve {
	@Override
	public String getName() {
		return "DECIMALMOVINGAVE";
	}

	@Override
	public String getDisplayName() {
		return "Decimal Moving Ave"; //$NON-NLS-1$
	}

	@Override
	public String getDescription() {
		return "Moving Average of Decimal Values";
	}

	@Override
	public int getDataType() {
		return DataType.DECIMAL_TYPE;
	}
}
