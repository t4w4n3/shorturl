package shorturl2

class ShortUrl {

	String fragment
	String url

	static constraints = {
		fragment unique: true, nullable: true
		url url: true, blank: false
	}

	void initFragment() {
		fragment = UUID.randomUUID().toString().take(5)
	}
}
