package vn.com.standford.springmvcbasic1.paging;

public class PageRequest implements Pageable {
   private Integer page;
   private Integer maxPageItem;
   private Shortter sort;
	public PageRequest(Integer page, Integer maxPageItem,Shortter sort) {
		this.page=page;
		this.maxPageItem=maxPageItem;
		this.sort=sort;
	}
	public Integer getPage() {
		return this.page;
	}

	public Integer getOffset() {
		if (this.page!=null && this.maxPageItem!=null) {
			return (this.page-1)*this.maxPageItem;
		}
		return null;
	}

	public Integer getlimit() {
		return this.maxPageItem;
	}
	public Shortter getSort() {
		return sort;
	}
	
	

}
