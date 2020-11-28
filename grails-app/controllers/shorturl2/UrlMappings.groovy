package shorturl2

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}

		"/$code"(controller: 'shortUrl', action: 'show')

		"/"(controller: 'shortUrl', action: "create")
		"500"(view: '/error')
		"404"(view: '/notFound')
	}
}
