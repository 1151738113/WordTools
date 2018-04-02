import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test {

    public static void main(String[] args)

    {

        Workbook readwb = null;

        try

        {

            //构建Workbook对象, 只读Workbook对象

            //直接从本地文件创建Workbook

            InputStream instream = new FileInputStream("C:/王伟/ww.xls");

            readwb = Workbook.getWorkbook(instream);



            //Sheet的下标是从0开始

            //获取第一张Sheet表

            Sheet readsheet = readwb.getSheet(0);

            //获取Sheet表中所包含的总列数

            int rsColumns = readsheet.getColumns();

            //获取Sheet表中所包含的总行数

            int rsRows = readsheet.getRows();

            String causes = null;

            String result = null;

            //获取指定单元格的对象引用

            for (int i = 0; i < rsRows; i++)

            {
                //获取俺有
                String cause = readsheet.getCell(0,i).getContents();
                if(!"".equals(cause)) {
                    causes = cause;
                }
                //获取文件名
                String name = readsheet.getCell(3,i).getContents();
                int xx = name.indexOf("_");
                String name1 = name.substring(xx+1, name.length());
               //获取类型
                String type = readsheet.getCell(4,i).getContents();
                //获取信息点
                String index = readsheet.getCell(7,i).getContents();

                if("int".equals(type)){
                    result = "{\"cause\":\""+causes+"\",\"searchType\":\"犯罪事实\",\"searchContent\":\""+name1+"\",\"esQuery\":[{\"jsonPath\":\""+index+"\",\"valueType\":\"Integer\",\"filterType\":\"Must\",\"queryType\":\"Range\"}]}";
                }
                if("boolean".equals(type)){
                    result = "{\"cause\":\""+causes+"\",\"searchType\":\"犯罪事实\",\"searchContent\":\""+name1+"\",\"esQuery\":[{\"jsonPath\":\""+index+"\",\"valueType\":\"Boolean\",\"filterType\":\"Must\",\"queryType\":\"Term\"}]}";
 result = "{\"cause\":\""+causes+"\",\"searchType\":\"犯罪事实\",\"searchContent\":\""+name1+"\",\"searchValue\":\"true\",\"esQuerys\":[{\"jsonPath\":\""+index+"\",\"value\":\"true\",\"valueType\":\"Boolean\",\"filterType\":\"Must\",\"queryType\":\"Term\"}]}"
                 +"\n"+
          "{\"cause\":\""+causes+"\",\"searchType\":\"犯罪事实\",\"searchContent\":\""+name1+"\",\"searchValue\":\"false\",\"esQuerys\":[{\"jsonPath\":\""+index+"\",\"value\":\"true\",\"valueType\":\"Boolean\",\"filterType\":\"MustNot\",\"queryType\":\"Term\"}]}";

                }
                if("List<String>".equals(type)){
                    result = "{\"cause\":\""+causes+"\",\"searchType\":\"犯罪事实\",\"searchContent\":\""+name1+"\",\"esQuery\":[{\"jsonPath\":\""+index+"\",\"valueType\":\"String\",\"filterType\":\"Must\",\"queryType\":\"Term\",\"formatter\":\"AccidentLiabilityFormatter\"}]}";
                }
                if("double".equals(type)){
                    result = "{\"cause\":\""+causes+"\",\"searchType\":\"犯罪事实\",\"searchContent\":\""+name1+"\",\"esQuery\":[{\"jsonPath\":\""+index+"\",\"valueType\":\"Double\",\"filterType\":\"Must\",\"queryType\":\"Range\"}]}";
                }

                System.out.println(result);

            }



        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            readwb.close();

        }

    }

}
