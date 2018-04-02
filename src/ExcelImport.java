import com.futuredata.base.core.util.AppUtils;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by wei.wang on 2017/11/13.
 */
public class ExcelImport {


  public static void main(String[] args) throws IOException, BiffException {
    Workbook readwb = null;
    Random random = new Random(100000000);

    InputStream instream = new FileInputStream("C:/wwproject/law.xls");

    readwb = Workbook.getWorkbook(instream);

    Sheet readsheet = readwb.getSheet(0);

    //获取Sheet表中所包含的总列数

    int rsColumns = readsheet.getColumns();

    //获取Sheet表中所包含的总行数

    int rsRows = readsheet.getRows();

    //记录法律全称
    List<String> list_laws = null;
    //记录法律简称
    List<String> list_jc = null;

    Map<String, String> map = new LinkedHashMap<>();

    Range[] rangeCell = readsheet.getMergedCells();

    for(int i = 1; i<rsRows; i++){
      for(int j =1;j<rsColumns;j++){
        //法律全称
        String law = readsheet.getCell(0,i).getContents();
        String laws = law+"#"+ random.nextInt();
        System.out.println("------------ :"+laws);
        //获取第j列第i行
        String str = null;
        str = readsheet.getCell(j,i).getContents();
        if("".equals(str)) {
          for (Range r : rangeCell) {
            if (i > r.getTopLeft().getRow() && i <= r.getBottomRight().getRow() && j >= r.getTopLeft().getColumn()
                && j <= r.getBottomRight().getColumn()) {
              str = readsheet.getCell(r.getTopLeft().getColumn(), r.getTopLeft().getRow()).getContents();
            }
          }
        }
        if("".equals(str)){
          break;
        }
//        if(law.equals(str)){
//          continue;
//        }
        map.put(laws,str);
      }
    }

    //将所有的简称放入一个Set里
    Set<String> set = new LinkedHashSet<>();
    for(Map.Entry<String, String> entry : map.entrySet()){
      set.add(entry.getValue());
    }
    for(String key:set){
      List<String> laws = new LinkedList<>();
      for(Map.Entry<String, String> entry : map.entrySet()){
        if(key.equals(entry.getValue())){
          String value = entry.getKey();
          int index = value.indexOf("#");
          String la = value.substring(0,index);
          laws.add(la);
        }
      }
      System.out.println(key+"\t"+laws);
    }





System.out.println("ssssss");
  }



}
