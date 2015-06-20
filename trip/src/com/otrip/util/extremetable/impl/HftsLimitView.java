package com.otrip.util.extremetable.impl;

import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.table.view.LimitToolbar;
import org.extremecomponents.util.HtmlBuilder;

/**
 * @see Hfts视图限制
 * @author zhongjc
 *
 */
public class HftsLimitView extends HftsHtmlView {
	
	protected void toolbar(HtmlBuilder html, TableModel model) {
        new LimitToolbar(html, model).layout();
    }

}
