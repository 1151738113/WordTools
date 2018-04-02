import java.util.List;


/*
 * EsMapper文件读取，设置其属性
 * 用于查询条件配置
 */
public class ESMapper {



	  private String cause;
	  private String searchType;
	  private String searchContent;
	  private String searchValue;
	  private String inputType;
	  private List<ESQuery> esQuerys;

	  public String getCause() {
	    return cause;
	  }

	  public void setCause(String cause) {
	    this.cause = cause;
	  }

	//  public String getClassfition() {
//	    return classfition;
	//  }
	//
	//  public void setClassfition(String classfition) {
//	    this.classfition = classfition;
	//  }
	  
	  public String getSearchType() {
		    return searchType;
		  }

		  public void setSearchType(String searchType) {
		    this.searchType = searchType;
		  }

	  public String getSearchContent() {
	    return searchContent;
	  }

	  public void setSearchContent(String searchContent) {
	    this.searchContent = searchContent;
	  }

	  public String getInputType() {
	    return inputType;
	  }

	  public void setInputType(String inputType) {
	    this.inputType = inputType;
	  }

	  public List<ESQuery> getEsQuerys() {
	    return esQuerys;
	  }

	  public void setEsQuerys(List<ESQuery> esQuerys) {
	    this.esQuerys = esQuerys;
	  }

	  public String getSearchValue() {
	    return searchValue;
	  }

	  public void setSearchValue(String searchValue) {
	    this.searchValue = searchValue;
	  }

	  @Override
	  public String toString() {
	    return "ESMapper [searchType=" + searchType + ", searchContent=" + searchContent
	        + ", inputType=" + inputType + ", esQuerys=" + esQuerys + "]";
	  }


	
	
}
