/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class IssueAward.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class IssueAward implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _issueType.
     */
    private java.lang.String _issueType;

    /**
     * Field _issueNumber.
     */
    private java.lang.String _issueNumber;

    /**
     * Field _tickets.
     */
    private com.taobao.caipiao.agentmock.generate.agent.config.Tickets _tickets;


      //----------------/
     //- Constructors -/
    //----------------/

    public IssueAward() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'issueNumber'.
     * 
     * @return the value of field 'IssueNumber'.
     */
    public java.lang.String getIssueNumber(
    ) {
        return this._issueNumber;
    }

    /**
     * Returns the value of field 'issueType'.
     * 
     * @return the value of field 'IssueType'.
     */
    public java.lang.String getIssueType(
    ) {
        return this._issueType;
    }

    /**
     * Returns the value of field 'tickets'.
     * 
     * @return the value of field 'Tickets'.
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Tickets getTickets(
    ) {
        return this._tickets;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'issueNumber'.
     * 
     * @param issueNumber the value of field 'issueNumber'.
     */
    public void setIssueNumber(
            final java.lang.String issueNumber) {
        this._issueNumber = issueNumber;
    }

    /**
     * Sets the value of field 'issueType'.
     * 
     * @param issueType the value of field 'issueType'.
     */
    public void setIssueType(
            final java.lang.String issueType) {
        this._issueType = issueType;
    }

    /**
     * Sets the value of field 'tickets'.
     * 
     * @param tickets the value of field 'tickets'.
     */
    public void setTickets(
            final com.taobao.caipiao.agentmock.generate.agent.config.Tickets tickets) {
        this._tickets = tickets;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * com.taobao.caipiao.agentmock.generate.agent.config.IssueAward
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.IssueAward unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.IssueAward) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.IssueAward.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
