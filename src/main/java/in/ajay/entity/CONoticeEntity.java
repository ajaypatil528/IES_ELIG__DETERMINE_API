package in.ajay.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CO_NOTICES")
public class CONoticeEntity {

	@Id
	@GeneratedValue
	private Integer noticeId;
	private Integer caseNum;
	private String noticeStatus;
	private String noticeUrl;
	private Integer edgTraceId;
	private LocalDate noticePrintDate;
	public Integer getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}
	public Integer getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}
	public String getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	public String getNoticeUrl() {
		return noticeUrl;
	}
	public void setNoticeUrl(String noticeUrl) {
		this.noticeUrl = noticeUrl;
	}
	public Integer getEdgTraceId() {
		return edgTraceId;
	}
	public void setEdgTraceId(Integer edgTraceId) {
		this.edgTraceId = edgTraceId;
	}
	public LocalDate getNoticePrintDate() {
		return noticePrintDate;
	}
	public void setNoticePrintDate(LocalDate noticePrintDate) {
		this.noticePrintDate = noticePrintDate;
	}
	
	
}
