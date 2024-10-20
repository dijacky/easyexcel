package com.alibaba.easyexcel.test.demo.write;

import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.AbstractCellStyleStrategy;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;

import java.util.List;

/**
 * Use the same style for the row
 *
 * @author Jiaju Zhuang
 */
@Getter
@Setter
@EqualsAndHashCode
public class CustomHorizontalCellStyleStrategy extends HorizontalCellStyleStrategy {
    public CustomHorizontalCellStyleStrategy(WriteCellStyle headWriteCellStyle,
                                             List<WriteCellStyle> contentWriteCellStyleList) {
        super(headWriteCellStyle, contentWriteCellStyleList);
    }

    public CustomHorizontalCellStyleStrategy(WriteCellStyle headWriteCellStyle, WriteCellStyle contentWriteCellStyle) {
        super(headWriteCellStyle, contentWriteCellStyle);
    }

    @Override
    protected void setContentCellStyle(CellWriteHandlerContext context) {
        Cell cell = context.getCell();
        if (cell.getRowIndex() == 1 && cell.getColumnIndex() == 1)
            super.setContentCellStyle(context);
    }
}
