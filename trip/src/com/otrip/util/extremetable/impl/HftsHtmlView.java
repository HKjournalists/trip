package com.otrip.util.extremetable.impl;

import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.table.view.AbstractHtmlView;
import org.extremecomponents.table.view.DefaultStatusBar;
import org.extremecomponents.table.view.DefaultToolbar;
import org.extremecomponents.util.HtmlBuilder;

/**
 * @see 修改分页的下方
 * @author zhongjc
 *
 */
public class HftsHtmlView extends AbstractHtmlView {

	protected void beforeBodyInternal(TableModel model) {
        //toolbar(getHtmlBuilder(), getTableModel());
        
        getTableBuilder().tableStart();

        getTableBuilder().theadStart();
        
        //statusBar(getHtmlBuilder(), getTableModel()); 
        
        getTableBuilder().filterRow();

        getTableBuilder().headerRow();

        getTableBuilder().theadEnd();

        getTableBuilder().tbodyStart();
    }

    protected void afterBodyInternal(TableModel model) {
        getCalcBuilder().defaultCalcLayout();

        getTableBuilder().tbodyEnd();

        getTableBuilder().tableEnd();
        
        //为了样式协调，需要将下面的两个模块修改写入一个table中
        //此处显示的为，记录的条数
        //statusBar(getHtmlBuilder(), getTableModel());    
        //将分页标签移到最下方，
        //toolbar(getHtmlBuilder(), getTableModel());
        
        statusAndToolbar(getHtmlBuilder(), getTableModel());
    }
    
    protected void toolbar(HtmlBuilder html, TableModel model) {
        new DefaultToolbar(html, model).layout();
    }

    protected void statusBar(HtmlBuilder html, TableModel model) {
        new DefaultStatusBar(html, model).layout();
    }
    
    /**
     * @see 如何写成一个table
     * @param html
     * @param model
     */
    protected void statusAndToolbar(HtmlBuilder html,TableModel model){
    	new HftsStatusAndToolsBar(html, model).layout();
    }

}
