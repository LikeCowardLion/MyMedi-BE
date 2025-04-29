package likecowardlion.mymedi.result.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseResultRankAllGetDTO {

    ResponseResultRankGetDTO userResultInfo;
    List<ResponseResultRankGetDTO> resultList;

}
