/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class Agent.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Agent implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _path.
     */
    private java.lang.String _path;

    /**
     * Field _title.
     */
    private java.lang.String _title;

    /**
     * Field _digestKey.
     */
    private java.lang.String _digestKey;

    /**
     * Field _issues.
     */
    private com.taobao.caipiao.agentmock.generate.agent.config.Issues _issues;

    /**
     * Field _getTicketResult.
     */
    private com.taobao.caipiao.agentmock.generate.agent.config.GetTicketResult _getTicketResult;

    /**
     * Field _getAwardTickets.
     */
    private com.taobao.caipiao.agentmock.generate.agent.config.GetAwardTickets _getAwardTickets;


      //----------------/
     //- Constructors -/
    //----------------/

    public Agent() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'digestKey'.
     * 
     * @return the value of field 'DigestKey'.
     */
    public java.lang.String getDigestKey(
    ) {
        return this._digestKey;
    }

    /**
     * Returns the value of field 'getAwardTickets'.
     * 
     * @return the value of field 'GetAwardTickets'.
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.GetAwardTickets getGetAwardTickets(
    ) {
        return this._getAwardTickets;
    }

    /**
     * Returns the value of field 'getTicketResult'.
     * 
     * @return the value of field 'GetTicketResult'.
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.GetTicketResult getGetTicketResult(
    ) {
        return this._getTicketResult;
    }

    /**
     * Returns the value of field 'issues'.
     * 
     * @return the value of field 'Issues'.
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Issues getIssues(
    ) {
        return this._issues;
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName(
    ) {
        return this._name;
    }

    /**
     * Returns the value of field 'path'.
     * 
     * @return the value of field 'Path'.
     */
    public java.lang.String getPath(
    ) {
        return this._path;
    }

    /**
     * Returns the value of field 'title'.
     * 
     * @return the value of field 'Title'.
     */
    public java.lang.String getTitle(
    ) {
        return this._title;
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
     * Sets the value of field 'digestKey'.
     * 
     * @param digestKey the value of field 'digestKey'.
     */
    public void setDigestKey(
            final java.lang.String digestKey) {
        this._digestKey = digestKey;
    }

    /**
     * Sets the value of field 'getAwardTickets'.
     * 
     * @param getAwardTickets the value of field 'getAwardTickets'.
     */
    public void setGetAwardTickets(
            final com.taobao.caipiao.agentmock.generate.agent.config.GetAwardTickets getAwardTickets) {
        this._getAwardTickets = getAwardTickets;
    }

    /**
     * Sets the value of field 'getTicketResult'.
     * 
     * @param getTicketResult the value of field 'getTicketResult'.
     */
    public void setGetTicketResult(
            final com.taobao.caipiao.agentmock.generate.agent.config.GetTicketResult getTicketResult) {
        this._getTicketResult = getTicketResult;
    }

    /**
     * Sets the value of field 'issues'.
     * 
     * @param issues the value of field 'issues'.
     */
    public void setIssues(
            final com.taobao.caipiao.agentmock.generate.agent.config.Issues issues) {
        this._issues = issues;
    }

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(
            final java.lang.String name) {
        this._name = name;
    }

    /**
     * Sets the value of field 'path'.
     * 
     * @param path the value of field 'path'.
     */
    public void setPath(
            final java.lang.String path) {
        this._path = path;
    }

    /**
     * Sets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(
            final java.lang.String title) {
        this._title = title;
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
     * com.taobao.caipiao.agentmock.generate.agent.config.Agent
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.Agent unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.Agent) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.Agent.class, reader);
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
