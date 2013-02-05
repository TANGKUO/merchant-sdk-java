package urn.ebay.apis.eBLBaseComponents;
import java.util.List;
import java.util.ArrayList;
import urn.ebay.apis.eBLBaseComponents.SubscriptionTermsType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import java.io.FileInputStream;
import java.io.StringReader;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * SubscriptionInfoType Information about a PayPal
 * Subscription. 
 */
public class SubscriptionInfoType{


	/**
	 * ID generated by PayPal for the subscriber. Character length
	 * and limitations: no limit	 
	 */ 
	private String subscriptionID;

	/**
	 * Subscription start date 	 
	 */ 
	private String subscriptionDate;

	/**
	 * Date when the subscription modification will be effective 	 
	 */ 
	private String effectiveDate;

	/**
	 * Date PayPal will retry a failed subscription payment 	 
	 */ 
	private String retryTime;

	/**
	 * Username generated by PayPal and given to subscriber to
	 * access the subscription. Character length and limitations:
	 * 64 alphanumeric single-byte characters	 
	 */ 
	private String username;

	/**
	 * Password generated by PayPal and given to subscriber to
	 * access the subscription. For security, the value of the
	 * password is hashed. Character length and limitations: 128
	 * alphanumeric single-byte characters	 
	 */ 
	private String password;

	/**
	 * The number of payment installments that will occur at the
	 * regular rate. Character length and limitations: no limit	 
	 */ 
	private String recurrences;

	/**
	 * Subscription duration and charges	 
	 */ 
	private List<SubscriptionTermsType> terms = new ArrayList<SubscriptionTermsType>();

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String reattempt;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String recurring;

	

	/**
	 * Default Constructor
	 */
	public SubscriptionInfoType (){
	}	

	/**
	 * Getter for subscriptionID
	 */
	 public String getSubscriptionID() {
	 	return subscriptionID;
	 }
	 
	/**
	 * Setter for subscriptionID
	 */
	 public void setSubscriptionID(String subscriptionID) {
	 	this.subscriptionID = subscriptionID;
	 }
	 
	/**
	 * Getter for subscriptionDate
	 */
	 public String getSubscriptionDate() {
	 	return subscriptionDate;
	 }
	 
	/**
	 * Setter for subscriptionDate
	 */
	 public void setSubscriptionDate(String subscriptionDate) {
	 	this.subscriptionDate = subscriptionDate;
	 }
	 
	/**
	 * Getter for effectiveDate
	 */
	 public String getEffectiveDate() {
	 	return effectiveDate;
	 }
	 
	/**
	 * Setter for effectiveDate
	 */
	 public void setEffectiveDate(String effectiveDate) {
	 	this.effectiveDate = effectiveDate;
	 }
	 
	/**
	 * Getter for retryTime
	 */
	 public String getRetryTime() {
	 	return retryTime;
	 }
	 
	/**
	 * Setter for retryTime
	 */
	 public void setRetryTime(String retryTime) {
	 	this.retryTime = retryTime;
	 }
	 
	/**
	 * Getter for username
	 */
	 public String getUsername() {
	 	return username;
	 }
	 
	/**
	 * Setter for username
	 */
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
	/**
	 * Getter for password
	 */
	 public String getPassword() {
	 	return password;
	 }
	 
	/**
	 * Setter for password
	 */
	 public void setPassword(String password) {
	 	this.password = password;
	 }
	 
	/**
	 * Getter for recurrences
	 */
	 public String getRecurrences() {
	 	return recurrences;
	 }
	 
	/**
	 * Setter for recurrences
	 */
	 public void setRecurrences(String recurrences) {
	 	this.recurrences = recurrences;
	 }
	 
	/**
	 * Getter for terms
	 */
	 public List<SubscriptionTermsType> getTerms() {
	 	return terms;
	 }
	 
	/**
	 * Setter for terms
	 */
	 public void setTerms(List<SubscriptionTermsType> terms) {
	 	this.terms = terms;
	 }
	 
	/**
	 * Getter for reattempt
	 */
	 public String getReattempt() {
	 	return reattempt;
	 }
	 
	/**
	 * Setter for reattempt
	 */
	 public void setReattempt(String reattempt) {
	 	this.reattempt = reattempt;
	 }
	 
	/**
	 * Getter for recurring
	 */
	 public String getRecurring() {
	 	return recurring;
	 }
	 
	/**
	 * Setter for recurring
	 */
	 public void setRecurring(String recurring) {
	 	this.recurring = recurring;
	 }
	 



	private  boolean isWhitespaceNode(Node n) {
		if (n.getNodeType() == Node.TEXT_NODE) {
			String val = n.getNodeValue();
			return val.trim().length() == 0;
		} else if (n.getNodeType() == Node.ELEMENT_NODE ) {
			return (n.getChildNodes().getLength() == 0);
		} else {
			return false;
		}
	}
	
	public SubscriptionInfoType(Node node) throws XPathExpressionException {
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		Node childNode = null;
		NodeList nodeList = null;
		childNode = (Node) xpath.evaluate("SubscriptionID", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.subscriptionID = childNode.getTextContent();
		}
	
		childNode = (Node) xpath.evaluate("SubscriptionDate", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.subscriptionDate = childNode.getTextContent();
		}
	
		childNode = (Node) xpath.evaluate("EffectiveDate", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.effectiveDate = childNode.getTextContent();
		}
	
		childNode = (Node) xpath.evaluate("RetryTime", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.retryTime = childNode.getTextContent();
		}
	
		childNode = (Node) xpath.evaluate("Username", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.username = childNode.getTextContent();
		}
	
		childNode = (Node) xpath.evaluate("Password", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.password = childNode.getTextContent();
		}
	
		childNode = (Node) xpath.evaluate("Recurrences", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.recurrences = childNode.getTextContent();
		}
	
        nodeList = (NodeList) xpath.evaluate("Terms", node, XPathConstants.NODESET);
		if (nodeList != null && nodeList.getLength() > 0) {
			for(int i=0; i < nodeList.getLength(); i++) {
				Node subNode = nodeList.item(i);
				this.terms.add(new SubscriptionTermsType(subNode));
			}
		}
		childNode = (Node) xpath.evaluate("reattempt", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.reattempt = childNode.getTextContent();
		}
	
		childNode = (Node) xpath.evaluate("recurring", node, XPathConstants.NODE);
		if (childNode != null && !isWhitespaceNode(childNode)) {
		    this.recurring = childNode.getTextContent();
		}
	
	}
 
}