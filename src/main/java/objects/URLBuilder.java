package objects;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;

public class URLBuilder {

	private List<URI> links;
	private String link;
	private int currentIndex;
	private int linksSize;

	public URLBuilder() {
		links = new ArrayList<URI>();
		linksSize = 0;
		currentIndex = 0;
	}

	public List<URI> getLinks() {
		return links;
	}

	public void setLinks(List<URI> links) {
		this.links = links;
		this.linksSize = links.size();
	}

	public int getLinksSize() {
		return linksSize;
	}

	public void setLinksSize(int linksSize) {
		this.linksSize = linksSize;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public List<URI> getAllLinks(String stockReference, String plate) {
		List<URI> tempLinks = setLinks(stockReference, plate, Size.SMALL);
		tempLinks.addAll(setLinks(stockReference, plate, Size.LARGE));
		return tempLinks;
	}

	public List<URI> getSmallLinks(String stockReference, String plate) {
		return setLinks(stockReference, plate, Size.SMALL);
	}

	public List<URI> getLargeLinks(String stockReference, String plate) {
		return setLinks(stockReference, plate, Size.LARGE);
	}

	public List<URI> setLinks(String stockReference, String plate, Size size) {
		List<URI> uris = new ArrayList<URI>();
		// Building links
		// One thing I noticed in the spec, you mention that camera can have one of six values
		// f, i, r, 4, 5 or 6.  However, later in the example, you have f, i, r and the numbers
		// 4 to 12.  I notice that numbers 7 to 12 are set to coming soon, but including them
		// anyway
		for(Camera camera : Camera.values()) {
			StringBuilder builder = new StringBuilder();
			builder.append("http://vcache.arnoldclark.com/imageserver/");
			builder.append(buildObfuscatedStockReference(stockReference, plate));

			URIBuilder uriBuilder = new URIBuilder()
			.setScheme("http")
			.setHost("vcache.arnoldclark.com")
			.setPath("/imageserver/" + buildObfuscatedStockReference(stockReference, plate) + "/" + size.getSize() + "/" + camera.getValue());

			URI uri;
			try {
				uri = uriBuilder.build();
				uris.add(uri);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return uris;
	}

	public String getReversedPlate(String plate) {
		return StringUtils.reverse(plate);
	}

	public String buildObfuscatedStockReference(String stockReference, String plate) {
		String reversedPlate = StringUtils.reverse(plate);
		String obfuscatedRef = interleaveStrings(stockReference, reversedPlate) + stockReference.charAt(8);
		return obfuscatedRef;
	}

	public String interleaveStrings(String a, String b) {
		// Always start with string a
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < a.length(); i++) {
			if(b.length() > i) {
				// Still characters to go, keep appending
				builder.append(a.charAt(i));
				builder.append(b.charAt(i));
			} else {
				// We've hit the end, break out
				break;
			}
		}
		return builder.toString();
	}
}
