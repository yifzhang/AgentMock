/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class GetAwardTickets.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class GetAwardTickets implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _issueAwardList.
     */
    private java.util.Vector<com.taobao.caipiao.agentmock.generate.agent.config.IssueAward> _issueAwardList;


      //----------------/
     //- Constructors -/
    //----------------/

    public GetAwardTickets() {
        super();
        this._issueAwardList = new java.util.Vector<com.taobao.caipiao.agentmock.generate.agent.config.IssueAward>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vIssueAward
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIssueAward(
            final com.taobao.caipiao.agentmock.generate.agent.config.IssueAward vIssueAward)
    throws java.lang.IndexOutOfBoundsException {
        this._issueAwardList.addElement(vIssueAward);
    }

    /**
     * 
     * 
     * @param index
     * @param vIssueAward
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIssueAward(
            final int index,
            final com.taobao.caipiao.agentmock.generate.agent.config.IssueAward vIssueAward)
    throws java.lang.IndexOutOfBoundsException {
        this._issueAwardList.add(index, vIssueAward);
    }

    /**
     * Method enumerateIssueAward.
     * 
     * @return an Enumeration over all
     * com.taobao.caipiao.agentmock.generate.agent.config.IssueAward
     * elements
     */
    public java.util.Enumeration<? extends com.taobao.caipiao.agentmock.generate.agent.config.IssueAward> enumerateIssueAward(
    ) {
        return this._issueAwardList.elements();
    }

    /**
     * Method getIssueAward.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.taobao.caipiao.agentmock.generate.agent.config.IssueAward
     * at the given index
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.IssueAward getIssueAward(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._issueAwardList.size()) {
            throw new IndexOutOfBoundsException("getIssueAward: Index value '" + index + "' not in range [0.." + (this._issueAwardList.size() - 1) + "]");
        }

        return (com.taobao.caipiao.agentmock.generate.agent.config.IssueAward) _issueAwardList.get(index);
    }

    /**
     * Method getIssueAward.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.IssueAward[] getIssueAward(
    ) {
        com.taobao.caipiao.agentmock.generate.agent.config.IssueAward[] array = new com.taobao.caipiao.agentmock.generate.agent.config.IssueAward[0];
        return (com.taobao.caipiao.agentmock.generate.agent.config.IssueAward[]) this._issueAwardList.toArray(array);
    }

    /**
     * Method getIssueAwardCount.
     * 
     * @return the size of this collection
     */
    public int getIssueAwardCount(
    ) {
        return this._issueAwardList.size();
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
     */
    public void removeAllIssueAward(
    ) {
        this._issueAwardList.clear();
    }

    /**
     * Method removeIssueAward.
     * 
     * @param vIssueAward
     * @return true if the object was removed from the collection.
     */
    public boolean removeIssueAward(
            final com.taobao.caipiao.agentmock.generate.agent.config.IssueAward vIssueAward) {
        boolean removed = _issueAwardList.remove(vIssueAward);
        return removed;
    }

    /**
     * Method removeIssueAwardAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.IssueAward removeIssueAwardAt(
            final int index) {
        java.lang.Object obj = this._issueAwardList.remove(index);
        return (com.taobao.caipiao.agentmock.generate.agent.config.IssueAward) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vIssueAward
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setIssueAward(
            final int index,
            final com.taobao.caipiao.agentmock.generate.agent.config.IssueAward vIssueAward)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._issueAwardList.size()) {
            throw new IndexOutOfBoundsException("setIssueAward: Index value '" + index + "' not in range [0.." + (this._issueAwardList.size() - 1) + "]");
        }

        this._issueAwardList.set(index, vIssueAward);
    }

    /**
     * 
     * 
     * @param vIssueAwardArray
     */
    public void setIssueAward(
            final com.taobao.caipiao.agentmock.generate.agent.config.IssueAward[] vIssueAwardArray) {
        //-- copy array
        _issueAwardList.clear();

        for (int i = 0; i < vIssueAwardArray.length; i++) {
                this._issueAwardList.add(vIssueAwardArray[i]);
        }
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
     * com.taobao.caipiao.agentmock.generate.agent.config.GetAwardTickets
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.GetAwardTickets unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.GetAwardTickets) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.GetAwardTickets.class, reader);
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
