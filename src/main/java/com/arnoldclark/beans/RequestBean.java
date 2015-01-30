package com.arnoldclark.beans;

import java.net.URI;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.arnoldclark.objects.URLBuilder;

@ManagedBean(name = "requestBean")
@SessionScoped
public class RequestBean {
 
	private String stockRef;
	private String plate;
	private URLBuilder urlBuilder;
	private boolean showImages;
	private List<URI> links;
	private List<URI> smallLinks;
	private List<URI> largeLinks;
	private String link;
	private int currentIndex;
	private String imageSize;
	@SuppressWarnings("unused")
	private boolean showSmallImages;
	
	public RequestBean() {
		stockRef = "";
		plate = "";
		urlBuilder = new URLBuilder();
		showImages = false;
		imageSize = "S";
		showSmallImages = true;
	}

	public void doRequest() {
		if(!showImages) {
			showImages = true;
			setLinks(urlBuilder.getAllLinks(stockRef, plate));
			setSmallLinks(urlBuilder.getSmallLinks(stockRef, plate));
			setLargeLinks(urlBuilder.getLargeLinks(stockRef, plate));
		}
	}
	
	public void back() {
		showImages = false;
	}
	
	public String getStockRef() {
		return stockRef;
	}
	public void setStockRef(String stockRef) {
		this.stockRef = stockRef;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public URLBuilder getUrlBuilder() {
		return urlBuilder;
	}

	public void setUrlBuilder(URLBuilder urlBuilder) {
		this.urlBuilder = urlBuilder;
	}

	public boolean isShowImages() {
		return showImages;
	}

	public void setShowImages(boolean showImages) {
		this.showImages = showImages;
	}

	public List<URI> getLinks() {
		return links;
	}

	public void setLinks(List<URI> links) {
		this.links = links;
		setLink(links.get(0).toString());
		setCurrentIndex(1);
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

	public String getImageSize() {
		return imageSize;
	}

	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}

	public boolean isShowSmallImages() {
		return getImageSize().equals("S") ? true : false;
	}

	public void setShowSmallImages(boolean showSmallImages) {
		this.showSmallImages = showSmallImages;
	}

	public List<URI> getSmallLinks() {
		return smallLinks;
	}

	public void setSmallLinks(List<URI> smallLinks) {
		this.smallLinks = smallLinks;
	}

	public List<URI> getLargeLinks() {
		return largeLinks;
	}

	public void setLargeLinks(List<URI> largeLinks) {
		this.largeLinks = largeLinks;
	}
}
