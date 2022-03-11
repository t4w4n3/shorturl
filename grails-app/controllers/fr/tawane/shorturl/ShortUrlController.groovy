package fr.tawane.shorturl

class ShortUrlController {
	static scaffold = ShortUrl

	def show(Long id) {
		redirect action: 'create', params: [id: id]
	}

	def create(String id) {
		respond new ShortUrl(params), model: [created: ShortUrl.get(id)]
	}

	def redirect(String segment) {
		redirect uri: ShortUrl.findBySegment(segment)?.url
	}
}
