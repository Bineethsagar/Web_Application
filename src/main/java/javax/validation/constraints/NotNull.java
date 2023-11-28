package javax.validation.constraints;

import org.springframework.stereotype.Component;

@Component
public class NotNull {
	
	public NotNull() {
		NotNull.this.equals("");
		
	}

}
