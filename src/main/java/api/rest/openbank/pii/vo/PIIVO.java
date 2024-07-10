package api.rest.openbank.pii.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PIIVO {
	private int no;
	private String name;
	private String phone;
	private char agree;
}
