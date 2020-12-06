package shorturl2


import java.util.concurrent.ThreadLocalRandom

import static org.apache.commons.lang3.RandomStringUtils.random

class ShortUrl {

	String fragment
	String url

	static constraints = {
		fragment nullable: true, size: 5..10, validator: { fragment, obj ->
			def minSize = constrainedProperties.fragment.size.from as int
			obj.fragment ?= random(minSize, 0, 0, true, true, null, ThreadLocalRandom.current())
			true
		}
		url url: true, blank: false
	}
}
