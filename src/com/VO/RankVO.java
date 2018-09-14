package com.VO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RankVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer rank_num;
	private String rank_name;
	private Set<RankReqVO> rankreqSet =new HashSet<RankReqVO>(0);
	private AssignRankVO assignRankVO;
	
	public String getRank_name() {
		return rank_name;
	}
	public void setRank_name(String rank_name) {
		this.rank_name = rank_name;
	}
	public Integer getRank_num() {
		return rank_num;
	}
	public void setRank_num(Integer rank_num) {
		this.rank_num = rank_num;
	}
	public Set<RankReqVO> getRankreqSet() {
		return rankreqSet;
	}
	public void setRankreqSet(Set<RankReqVO> rankreqSet) {
		this.rankreqSet = rankreqSet;
	}
	public AssignRankVO getAssignRankVO() {
		return assignRankVO;
	}
	public void setAssignRankVO(AssignRankVO assignRankVO) {
		this.assignRankVO = assignRankVO;
	}

}
