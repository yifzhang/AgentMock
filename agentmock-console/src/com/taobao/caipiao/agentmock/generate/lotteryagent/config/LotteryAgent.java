/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.lotteryagent.config;

/**
 * Class LotteryAgent.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class LotteryAgent implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _description.
     */
    private java.lang.String _description;

    /**
     * Field _agentName.
     */
    private java.lang.String _agentName;

    /**
     * Field _agentClass.
     */
    private java.lang.String _agentClass;

    /**
     * Field _ftpUrl.
     */
    private java.lang.String _ftpUrl;


      //----------------/
     //- Constructors -/
    //----------------/

    public LotteryAgent() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'agentClass'.
     * 
     * @return the value of field 'AgentClass'.
     */
    public java.lang.String getAgentClass(
    ) {
        return this._agentClass;
    }

    /**
     * Returns the value of field 'agentName'.
     * 
     * @return the value of field 'AgentName'.
     */
    public java.lang.String getAgentName(
    ) {
        return this._agentName;
    }

    /**
     * Returns the value of field 'description'.
     * 
     * @return the value of field 'Description'.
     */
    public java.lang.String getDescription(
    ) {
        return this._description;
    }

    /**
     * Returns the value of field 'ftpUrl'.
     * 
     * @return the value of field 'FtpUrl'.
     */
    public java.lang.String getFtpUrl(
    ) {
        return this._ftpUrl;
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
     * Sets the value of field 'agentClass'.
     * 
     * @param agentClass the value of field 'agentClass'.
     */
    public void setAgentClass(
            final java.lang.String agentClass) {
        this._agentClass = agentClass;
    }

    /**
     * Sets the value of field 'agentName'.
     * 
     * @param agentName the value of field 'agentName'.
     */
    public void setAgentName(
            final java.lang.String agentName) {
        this._agentName = agentName;
    }

    /**
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(
            final java.lang.String description) {
        this._description = description;
    }

    /**
     * Sets the value of field 'ftpUrl'.
     * 
     * @param ftpUrl the value of field 'ftpUrl'.
     */
    public void setFtpUrl(
            final java.lang.String ftpUrl) {
        this._ftpUrl = ftpUrl;
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
     * com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent
     */
    public static com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.lotteryagent.config.LotteryAgent.class, reader);
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
