package shorturl2

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.NOT_FOUND

class ShortUrlController {

	static scaffold = ShortUrl

	ShortUrlService shortUrlService

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond shortUrlService.list(params), model: [shortUrlCount: shortUrlService.count()]
	}

	def show(Long id) {
		redirect uri: ShortUrl.findByIdOrFragment(id, params.fragment as String)?.url
	}

	def create(String id) {
		respond new ShortUrl(params), model: [created: ShortUrl.get(id)]
	}

	def save(ShortUrl shortUrl) {
		if (shortUrl == null) {
			notFound()
			return
		}

		if (!shortUrl.fragment) shortUrl.initFragment()

		try {
			shortUrlService.save(shortUrl)
		} catch (ValidationException e) {
			respond shortUrl.errors, view: 'create'
			return
		}

		redirect action: 'create', params: [id: shortUrl.id]
	}

	def edit() {
		render(status: 404)
	}

	def update() {
		render(status: 404)
	}

	def delete() {
		render(status: 404)
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
