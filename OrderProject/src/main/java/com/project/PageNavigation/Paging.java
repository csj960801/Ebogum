package com.project.PageNavigation;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Paging {

	private int firstPageNo;
	private int lastPageNo;
	private int prevPageNo;
	private int nextPageNo;
	private int beginPageNo;
	private int endPageNo;
	private int beginRowNo;
	private int endRowNo;
	private int totalCnt;
	private int currentPageNo;
	private int pageRowCnt;
	private HttpServletRequest req;

	public int getEndRowNo() {
		return endRowNo;
	}

	public void setEndRowNo(int endRowNo) {
		this.endRowNo = endRowNo;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getPageRowCnt() {
		return pageRowCnt;
	}

	public void setPageRowCnt(int pageRowCnt) {
		this.pageRowCnt = pageRowCnt;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getLastPageNo() {
		return lastPageNo;
	}

	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}

	public int getPrevPageNo() {
		return prevPageNo;
	}

	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getBeginPageNo() {
		return beginPageNo;
	}

	public void setBeginPageNo(int beginPageNo) {
		this.beginPageNo = beginPageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getBeginRowNo() {
		return beginRowNo;
	}

	public void setBeginRowNo(int beginRowNo) {
		this.beginRowNo = beginRowNo;
	}

	/**
	 * 한 페이지에서 보여줄 게시글 총 번호 수
	 * 
	 * @param totalCnt
	 * @param pageRowCnt
	 * @param currentPageNo
	 * @param req
	 */
	public void setNavigationInfo(int totalCnt, int pageRowCnt, int currentPageNo, HttpServletRequest req) {
		this.totalCnt = totalCnt;
		this.pageRowCnt = pageRowCnt;
		this.currentPageNo = currentPageNo;
		this.req = req;

		this.firstPageNo = 1;
		this.lastPageNo = (totalCnt / pageRowCnt);

		if ((totalCnt % pageRowCnt) > 0) {
			lastPageNo++;
		}

		// 페이지 시작 수 리턴 변수
		this.beginPageNo = ((currentPageNo - 1) / 10) * 10 + 1;

		// 페이지 마지막 수
		this.endPageNo = beginPageNo + 9;

		if (endPageNo > lastPageNo) {
			endPageNo = lastPageNo;
		}

		this.prevPageNo = beginPageNo - 1;
		if (prevPageNo < firstPageNo) {
			prevPageNo = 1;
		}

		this.nextPageNo = endPageNo + 1;
		if (nextPageNo > lastPageNo) {
			nextPageNo = lastPageNo;
		}

		this.beginRowNo = (currentPageNo - 1) * pageRowCnt;
		this.endRowNo = (currentPageNo * pageRowCnt) + 1;

	}// end of setNavigationInfo()

	/**
	 * 페이지 번호 출력(PrintWriter로 출력될 함수)
	 * 
	 * @return
	 */
	public String getNavigationStr() {
		StringBuffer cntbuffer = new StringBuffer();

		if (nextPageNo >= 2) {
			cntbuffer.append("<a href='javascript:goPage(" + firstPageNo + ")'>" + firstPageNo + "</a>");
			cntbuffer.append("<a href='javascript:goPage(" + prevPageNo + ")'>" + prevPageNo + "</a> <");
		}

		for (int i = beginPageNo; i <= endPageNo; i++) {
			if (i == currentPageNo) {
			
				cntbuffer.append("<a href='#'>" + i + "</a>");
			
			} else {
				cntbuffer.append("<a href='javascript:goPage(" + i + ")'>[" + i + "]</a>");
			}
		}

		if (nextPageNo >= 2) {
			cntbuffer.append("> <a href='javascript:goPage(" + nextPageNo + ")'>" + nextPageNo + "</a>");
			cntbuffer.append("<a href='javascript:goPage(" + lastPageNo + ")'>" + lastPageNo + "</a>");
		}
		return cntbuffer.toString();
	}// end of getNavigationStr()

	/**
	 * 폼 생성(PrintWriter로 출력될 함수)
	 * 
	 * @return
	 */
	public String getMakeParaForm() {
		StringBuffer sb = new StringBuffer();
		Enumeration enu = req.getParameterNames();
	
		sb.append("<form name='pageForm' method='post'>");
		sb.append("<input type='hidden' name='pageNo' value='" + currentPageNo + "'/>");
	
		while (enu.hasMoreElements()) {
			String pName = (String) enu.nextElement();
			String pValue = req.getParameter(pName);

			if (!pName.equals("pageNo")) {
				sb.append("<input type='hidden' name='" + pName + "' value='" + pValue + "'/>");
			}
		} // end of while

		sb.append("</form>");
		sb.append("");

		sb.append("<script>");
		sb.append("function goPage(pageNo){");
		sb.append("var doc = document.pageForm;");
		sb.append("doc.pageNo.value = pageNo;");
		sb.append("doc.action='/board/FreeBoard.board';");
		sb.append("doc.submit();");
		sb.append("");
		sb.append("}");
		sb.append("</script>");

		return sb.toString();
	}

}