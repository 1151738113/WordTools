import com.futuredata.base.core.util.JsonUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${ww} on ${DATA}.
 * 该方法目的对比两个文件的字符串是否匹配正确
 */
public class FileComparator {

  public static void main(String[] args) throws UnsupportedEncodingException {

   Map<String, ESMapper> propertiesMap = new HashMap<>();
    //读取ESMapper
    InputStream in = FileComparator.class.getClassLoader().getResourceAsStream("C:\\王伟\\untitled\\src\\ServiceDataFile.txt");

    BufferedReader br;
    try {

      InputStreamReader read = new InputStreamReader(in, "UTF-8");
      br = new BufferedReader(read);

      for (String line = br.readLine();
           line != null && line.trim().length() > 0; line = br.readLine()) {
        if (line.startsWith("#")) {
          continue;
        }
        ESMapper mapper = JsonUtils.toObject(line, ESMapper.class);
        String key = mapper.getSearchType();
        if (mapper.getCause() != null) {
          key = mapper.getCause().concat(key);
        }
        if (mapper.getSearchContent() != null) {
          key = key.concat(mapper.getSearchContent());
        }
        if (mapper.getSearchValue() != null) {
          key = key.concat(mapper.getSearchValue());
        }
        propertiesMap.put(key, mapper);
      }
      br.close();
      read.close();
      in.close();
    } catch (Exception ex) {

    }

    System.out.println(propertiesMap);


  }

}
