package vn.com.standford.springmvcbasic1.paging;

public interface Pageable {
	Integer getPage();
	Integer getOffset();
	Integer getlimit();
	public Shortter getSort();
}
