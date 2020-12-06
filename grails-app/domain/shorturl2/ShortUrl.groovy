package shorturl2

import java.util.concurrent.ThreadLocalRandom

import static org.apache.commons.lang3.RandomStringUtils.random

class ShortUrl {

	String fragment
	String url

	static constraints = {
		fragment nullable: true, size: 5..10, unique: true
		url url: true, blank: false
	}

	protected String getRandomAlphaNumeric() {
		def fragmentMinSize = constrainedProperties.fragment.size.from as int
		random(fragmentMinSize, 0, 0, true, true, null, ThreadLocalRandom.current())
	}

	def beforeValidate() {
		fragment ?= randomAlphaNumeric
	}
}
