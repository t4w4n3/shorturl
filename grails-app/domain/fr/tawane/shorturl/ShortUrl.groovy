package fr.tawane.shorturl

import org.apache.commons.lang3.RandomStringUtils

class ShortUrl {

	String segment
	String url

	static constraints = {
		segment unique: true, size: 5..10, matches: "[0-9a-zA-Z]*", nullable: true
		url url: true, blank: false
	}

	protected String getRandomAlphaNumeric() {
		def segmentMinSize = constrainedProperties.segment.size.from as int
		RandomStringUtils.randomAlphanumeric(segmentMinSize)
	}

	def beforeValidate() {
		if (!segment) {
			do {
				segment = randomAlphaNumeric
			} while (hasDuplicatedSegment())
		}
	}

	boolean hasDuplicatedSegment() {
		!validate() &&
				errors.fieldErrors?.find { it.field == 'segment' }?.code == 'unique'
	}

}
