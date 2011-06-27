/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class Issue.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Issue implements java.io.Serializable {


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
     * Field _startTime.
     */
    private java.lang.String _startTime;

    /**
     * Field _endTime.
     */
    private java.lang.String _endTime;

    /**
     * Field _status.
     */
    private java.lang.String _status;

    /**
     * Field _bonusCode.
     */
    private java.lang.String _bonusCode;


      //----------------/
     //- Constructors -/
    //----------------/

    public Issue() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bonusCode'.
     * 
     * @return the value of field 'BonusCode'.
     */
    public java.lang.String getBonusCode(
    ) {
        return this._bonusCode;
    }

    /**
     * Returns the value of field 'endTime'.
     * 
     * @return the value of field 'EndTime'.
     */
    public java.lang.String getEndTime(
    ) {
        return this._endTime;
    }

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
     * Returns the value of field 'startTime'.
     * 
     * @return the value of field 'StartTime'.
     */
    public java.lang.String getStartTime(
    ) {
        return this._startTime;
    }

    /**
     * Returns the value of field 'status'.
     * 
     * @return the value of field 'Status'.
     */
    public java.lang.String getStatus(
    ) {
        return this._status;
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
     * Sets the value of field 'bonusCode'.
     * 
     * @param bonusCode the value of field 'bonusCode'.
     */
    public void setBonusCode(
            final java.lang.String bonusCode) {
        this._bonusCode = bonusCode;
    }

    /**
     * Sets the value of field 'endTime'.
     * 
     * @param endTime the value of field 'endTime'.
     */
    public void setEndTime(
            final java.lang.String endTime) {
        this._endTime = endTime;
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
     * Sets the value of field 'startTime'.
     * 
     * @param startTime the value of field 'startTime'.
     */
    public void setStartTime(
            final java.lang.String startTime) {
        this._startTime = startTime;
    }

    /**
     * Sets the value of field 'status'.
     * 
     * @param status the value of field 'status'.
     */
    public void setStatus(
            final java.lang.String status) {
        this._status = status;
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
     * com.taobao.caipiao.agentmock.generate.agent.config.Issue
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.Issue unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.Issue) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.Issue.class, reader);
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
