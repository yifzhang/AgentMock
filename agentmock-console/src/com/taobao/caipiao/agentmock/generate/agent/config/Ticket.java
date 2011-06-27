/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class Ticket.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Ticket implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ticketNo.
     */
    private java.lang.String _ticketNo;

    /**
     * Field _awardType.
     */
    private java.lang.String _awardType;

    /**
     * Field _awardMoney.
     */
    private java.lang.String _awardMoney;


      //----------------/
     //- Constructors -/
    //----------------/

    public Ticket() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'awardMoney'.
     * 
     * @return the value of field 'AwardMoney'.
     */
    public java.lang.String getAwardMoney(
    ) {
        return this._awardMoney;
    }

    /**
     * Returns the value of field 'awardType'.
     * 
     * @return the value of field 'AwardType'.
     */
    public java.lang.String getAwardType(
    ) {
        return this._awardType;
    }

    /**
     * Returns the value of field 'ticketNo'.
     * 
     * @return the value of field 'TicketNo'.
     */
    public java.lang.String getTicketNo(
    ) {
        return this._ticketNo;
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
     * Sets the value of field 'awardMoney'.
     * 
     * @param awardMoney the value of field 'awardMoney'.
     */
    public void setAwardMoney(
            final java.lang.String awardMoney) {
        this._awardMoney = awardMoney;
    }

    /**
     * Sets the value of field 'awardType'.
     * 
     * @param awardType the value of field 'awardType'.
     */
    public void setAwardType(
            final java.lang.String awardType) {
        this._awardType = awardType;
    }

    /**
     * Sets the value of field 'ticketNo'.
     * 
     * @param ticketNo the value of field 'ticketNo'.
     */
    public void setTicketNo(
            final java.lang.String ticketNo) {
        this._ticketNo = ticketNo;
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
     * com.taobao.caipiao.agentmock.generate.agent.config.Ticket
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.Ticket unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.Ticket) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.Ticket.class, reader);
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
