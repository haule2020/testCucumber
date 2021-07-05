package bodyRequests;

public class TokenRequests {
	public String client_id;
	public String client_secret;
	public String grant_type;

	public TokenRequests(String clientId, String clientSecret, String grantType) {
	super();
	this.client_id = clientId;
	this.client_secret = clientSecret;
	this.grant_type = grantType;
	}

}
