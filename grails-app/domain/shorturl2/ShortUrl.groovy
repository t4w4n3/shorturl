package shorturl2

class ShortUrl {

	String code
	String url

	static constraints = {
		code unique: true, nullable: true
		url url: true, blank: false
	}

	void initCode() {
		code = UUID.randomUUID().toString().take(5)
	}
}
