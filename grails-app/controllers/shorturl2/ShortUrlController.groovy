package shorturl2


import static org.springframework.http.HttpStatus.NOT_FOUND

class ShortUrlController {

	static scaffold = ShortUrl

	ShortUrlService shortUrlService

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def redirect(String fragment) {
		redirect uri: ShortUrl.findByFragment(fragment)?.url
	}

	def show(Long id) {
		redirect action: 'create', params: [id: id]
	}

	def create(String id) {
		respond new ShortUrl(params), model: [created: ShortUrl.get(id)]
	}

	def edit(Long id) {
		respond shortUrlService.get(id)
	}

	def update() {
		render status: 404
	}

	def delete() {
		render status: 404
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'shortUrl.label', default: 'ShortUrl'), params.id])
				redirect action: "index", method: "GET"
			}
			'*' { render status: NOT_FOUND }
		}
	}
}
