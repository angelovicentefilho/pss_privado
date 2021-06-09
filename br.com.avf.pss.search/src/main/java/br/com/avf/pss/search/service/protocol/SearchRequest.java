package br.com.avf.pss.search.service.protocol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SearchRequest {

	private String origin;
	private String destination;
	private String flightDate;

}
