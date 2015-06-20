package com.otrip.util.extremetable.impl;

import java.util.Iterator;

import org.extremecomponents.table.bean.Export;
import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.table.view.html.BuilderConstants;
import org.extremecomponents.table.view.html.BuilderUtils;
import org.extremecomponents.table.view.html.StatusBarBuilder;
import org.extremecomponents.table.view.html.TableBuilder;
import org.extremecomponents.table.view.html.ToolbarBuilder;
import org.extremecomponents.util.HtmlBuilder;

import com.otrip.util.extremetable.ThreeColumnRowLayout;

/**
 * @see 要求把分页栏目和状态栏目显示在一列一个表格
 * @author zhongjc
 *
 */
public class HftsStatusAndToolsBar extends ThreeColumnRowLayout {

	public HftsStatusAndToolsBar(HtmlBuilder html, TableModel model) {
		super(html, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean showLayout(TableModel model) {
		// TODO Auto-generated method stub
		boolean showStatusBar = BuilderUtils.showStatusBar(model);
        boolean filterable = BuilderUtils.filterable(model);
        
        boolean showPagination = BuilderUtils.showPagination(model);
        boolean showExports = BuilderUtils.showExports(model);
        boolean showTitle = BuilderUtils.showTitle(model);
        if ((!showStatusBar && !filterable)||(!showPagination && !showExports && !showTitle)) {
            return false;
        }

        return true;
	}

	@Override
	protected void columnLeft(HtmlBuilder html, TableModel model) {
		// TODO Auto-generated method stub
		
		boolean showStatusBar = BuilderUtils.showStatusBar(model);
        if (!showStatusBar) {
            return;
        }

        html.td(4).styleClass(BuilderConstants.STATUS_BAR_CSS).close();

        new StatusBarBuilder(html, model).statusMessage();

        html.tdEnd();

	}

	@Override
	protected void columnCenter(HtmlBuilder html, TableModel model) {
		// TODO Auto-generated method stub
		boolean filterable = BuilderUtils.filterable(model);
        if (!filterable) {
            return;
        }

        html.td(4).styleClass(BuilderConstants.FILTER_BUTTONS_CSS).close();

        html.img();
        html.src(BuilderUtils.getImage(model, BuilderConstants.TOOLBAR_FILTER_ARROW_IMAGE));
        html.style("border:0");
        html.alt("Arrow");
        html.xclose();

        html.nbsp();

        ToolbarBuilder toolbarBuilder = new ToolbarBuilder(html, model);
        toolbarBuilder.filterItemAsImage();

        html.nbsp();

        toolbarBuilder.clearItemAsImage();

        html.tdEnd();
        
        //下面为toolbar的left部分
        html.td(2).close();
        new TableBuilder(html, model).title();
        html.tdEnd();

	}

	@Override
	protected void columnRight(HtmlBuilder html, TableModel model) {
		// TODO Auto-generated method stub
		
		boolean showPagination = BuilderUtils.showPagination(model);
        boolean showExports = BuilderUtils.showExports(model);

        ToolbarBuilder toolbarBuilder = new ToolbarBuilder(html, model);

        html.td(2).align("right").close();

        //html.table(2).border("0").cellPadding("0").cellSpacing("1").styleClass(BuilderConstants.TOOLBAR_CSS).close();
        html.table(2).border("0").cellPadding("0").cellSpacing("1").styleClass(BuilderConstants.STATUS_BAR_CSS).close();
        
        html.tr(3).close();

        if (showPagination) {

            html.td(4).close();
            //对于下面，全部去掉图片,
            toolbarBuilder.firstPageItemAsImage();
            //toolbarBuilder.firstPageItemAsText();
            html.tdEnd();

            html.td(4).close();
            toolbarBuilder.prevPageItemAsImage();
            //toolbarBuilder.prevPageItemAsText();
            html.tdEnd();

            html.td(4).close();
            toolbarBuilder.nextPageItemAsImage();
            //toolbarBuilder.nextPageItemAsText();
            html.tdEnd();

            html.td(4).close();
            toolbarBuilder.lastPageItemAsImage();
            //toolbarBuilder.lastPageItemAsText();
            html.tdEnd();

            html.td(4).close();
            toolbarBuilder.separator();
            html.tdEnd();

            html.td(4).style("width:20px").close();
            html.newline();
            html.tabs(4);
            toolbarBuilder.rowsDisplayedDroplist();
            //html.img();
            //html.src(BuilderUtils.getImage(model, BuilderConstants.TOOLBAR_ROWS_DISPLAYED_IMAGE));
            //html.src(BuilderUtils.getImage(model, BuilderConstants.TOOLBAR_FILTER_ARROW_IMAGE));
            
            //html.style("border:0");
            //html.alt("Rows Displayed");
            //html.xclose();
            html.tdEnd();

            if (showExports) {
                html.td(4).close();
                toolbarBuilder.separator();
                html.tdEnd();
            }
        }

        if (showExports) {
            Iterator iterator = model.getExportHandler().getExports().iterator();
            for (Iterator iter = iterator; iter.hasNext();) {
                html.td(4).align("left").close();
                Export export = (Export) iter.next();
                toolbarBuilder.exportItemAsImage(export);
                html.tdEnd();
            }
        }

        html.trEnd(3);

        html.tableEnd(2);
        html.newline();
        html.tabs(2);

        html.tdEnd();

	}

}
