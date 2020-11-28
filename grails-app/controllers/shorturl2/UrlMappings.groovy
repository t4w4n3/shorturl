package shorturl2

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}

		"/"(controller: 'shortUrl', action: "create")
		"500"(view: '/error')
		"404"(view: '/notFound')
	}
}
