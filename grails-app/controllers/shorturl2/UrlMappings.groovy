package shorturl2

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				action inList: ['show', 'index', 'save']
				controller inList: ['shortUrl']
			}
		}

		"/$fragment"(controller: 'shortUrl', action: 'redirect')

		"/"(controller: 'shortUrl', action: "create")
		"500"(view: '/error')
		"404"(view: '/notFound')
	}
}
