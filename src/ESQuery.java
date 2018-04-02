import com.futuredata.SimLawCase.Recommender.domain.FilterType;
import com.futuredata.SimLawCase.Recommender.domain.QueryType;

/*
 * ES查询条件配置
 * 与es后端关联
 */


public class ESQuery {

	private String jsonPath;
	private QueryType queryType;
	private FilterType filterType;
	private String valueType;
	private String value;
	//是否为短语
	private Boolean isphrase = false;
	private String formatter;
	private String group;
	// 是否允许Null，作为检索条件 true:不允许
	private boolean notNull;

	public String getJsonPath() {
		return jsonPath;
	}

	public void setJsonPath(String jsonPath) {
		this.jsonPath = jsonPath;
	}

	public QueryType getQueryType() {
		return queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	public FilterType getFilterType() {
		return filterType;
	}

	public void setFilterType(FilterType filterType) {
		this.filterType = filterType;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean isNotNull() {
		return notNull;
	}

	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}

	public Boolean getIsphrase(){
		return isphrase;
	}

	public void setIsphrase(boolean isphrase) {
		this.isphrase = isphrase;
	}

	@Override
	public String toString() {
		return "ESQuery [jsonPath=" + jsonPath + ", queryType=" + queryType + ", filterType=" + filterType
				+ ", valueType=" + valueType + ", value=" + value + ", formatter=" + formatter + "]";
	}

}
