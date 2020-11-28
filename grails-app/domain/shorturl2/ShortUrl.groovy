package shorturl2

class ShortUrl {

	String code
	String url

	static constraints = {
		code unique: true
		url url: true
	}

	void initCode() {
		code = UUID.randomUUID().toString().take(5)
	}
}
