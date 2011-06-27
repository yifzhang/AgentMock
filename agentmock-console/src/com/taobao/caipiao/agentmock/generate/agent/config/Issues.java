/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.taobao.caipiao.agentmock.generate.agent.config;

/**
 * Class Issues.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Issues implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _issueList.
     */
    private java.util.Vector<com.taobao.caipiao.agentmock.generate.agent.config.Issue> _issueList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Issues() {
        super();
        this._issueList = new java.util.Vector<com.taobao.caipiao.agentmock.generate.agent.config.Issue>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vIssue
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIssue(
            final com.taobao.caipiao.agentmock.generate.agent.config.Issue vIssue)
    throws java.lang.IndexOutOfBoundsException {
        this._issueList.addElement(vIssue);
    }

    /**
     * 
     * 
     * @param index
     * @param vIssue
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addIssue(
            final int index,
            final com.taobao.caipiao.agentmock.generate.agent.config.Issue vIssue)
    throws java.lang.IndexOutOfBoundsException {
        this._issueList.add(index, vIssue);
    }

    /**
     * Method enumerateIssue.
     * 
     * @return an Enumeration over all
     * com.taobao.caipiao.agentmock.generate.agent.config.Issue
     * elements
     */
    public java.util.Enumeration<? extends com.taobao.caipiao.agentmock.generate.agent.config.Issue> enumerateIssue(
    ) {
        return this._issueList.elements();
    }

    /**
     * Method getIssue.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.taobao.caipiao.agentmock.generate.agent.config.Issue at
     * the given index
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Issue getIssue(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._issueList.size()) {
            throw new IndexOutOfBoundsException("getIssue: Index value '" + index + "' not in range [0.." + (this._issueList.size() - 1) + "]");
        }

        return (com.taobao.caipiao.agentmock.generate.agent.config.Issue) _issueList.get(index);
    }

    /**
     * Method getIssue.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Issue[] getIssue(
    ) {
        com.taobao.caipiao.agentmock.generate.agent.config.Issue[] array = new com.taobao.caipiao.agentmock.generate.agent.config.Issue[0];
        return (com.taobao.caipiao.agentmock.generate.agent.config.Issue[]) this._issueList.toArray(array);
    }

    /**
     * Method getIssueCount.
     * 
     * @return the size of this collection
     */
    public int getIssueCount(
    ) {
        return this._issueList.size();
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
    public void removeAllIssue(
    ) {
        this._issueList.clear();
    }

    /**
     * Method removeIssue.
     * 
     * @param vIssue
     * @return true if the object was removed from the collection.
     */
    public boolean removeIssue(
            final com.taobao.caipiao.agentmock.generate.agent.config.Issue vIssue) {
        boolean removed = _issueList.remove(vIssue);
        return removed;
    }

    /**
     * Method removeIssueAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.taobao.caipiao.agentmock.generate.agent.config.Issue removeIssueAt(
            final int index) {
        java.lang.Object obj = this._issueList.remove(index);
        return (com.taobao.caipiao.agentmock.generate.agent.config.Issue) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vIssue
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setIssue(
            final int index,
            final com.taobao.caipiao.agentmock.generate.agent.config.Issue vIssue)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._issueList.size()) {
            throw new IndexOutOfBoundsException("setIssue: Index value '" + index + "' not in range [0.." + (this._issueList.size() - 1) + "]");
        }

        this._issueList.set(index, vIssue);
    }

    /**
     * 
     * 
     * @param vIssueArray
     */
    public void setIssue(
            final com.taobao.caipiao.agentmock.generate.agent.config.Issue[] vIssueArray) {
        //-- copy array
        _issueList.clear();

        for (int i = 0; i < vIssueArray.length; i++) {
                this._issueList.add(vIssueArray[i]);
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
     * com.taobao.caipiao.agentmock.generate.agent.config.Issues
     */
    public static com.taobao.caipiao.agentmock.generate.agent.config.Issues unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.taobao.caipiao.agentmock.generate.agent.config.Issues) org.exolab.castor.xml.Unmarshaller.unmarshal(com.taobao.caipiao.agentmock.generate.agent.config.Issues.class, reader);
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
