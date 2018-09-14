package com.VO;

import java.io.Serializable;

public class RankReqVO implements Serializable {

		private static final long serialVersionUID = 1L;
		private Integer rank_req_id;
		private String rank_req_desc;
		private RankVO rank;
		
		public RankVO getRank() {
			return rank;
		}
		public void setRank(RankVO rank) {
			this.rank = rank;
		}
		
		public Integer getRank_req_id() {
			return rank_req_id;
		}
		public void setRank_req_id(Integer rank_req_id) {
			this.rank_req_id = rank_req_id;
		}
		public String getRank_req_desc() {
			return rank_req_desc;
		}
		public void setRank_req_desc(String rank_req_desc) {
			this.rank_req_desc = rank_req_desc;
		}


}
