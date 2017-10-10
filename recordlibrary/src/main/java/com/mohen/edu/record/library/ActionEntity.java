package com.mohen.edu.record.library;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "action")
public class ActionEntity{

    @Column(name = "id", isId = true)
    private int id;
    @Column(name = "name")
	private String name;// 自定义名称
    @Column(name = "v1")
	private int v1;// 第一个描述数据
    @Column(name = "v2")
	private int v2;// 第二个描述数据
    @Column(name = "kid")
	private String kid;// 知识点id
    @Column(name = "sid")
	private String sid;// 科目id
    @Column(name = "type")
	private int type;// 行为类型
    @Column(name = "cfg")
	private String cfg;//配置说明数据

	public ActionEntity() {
	}

	public ActionEntity(String name, int v1, int v2, String kid, String sid, int type, String cfg) {
		super();
		this.name = name;
		this.v1 = v1;
		this.v2 = v2;
		this.kid = kid;
		this.sid = sid;
		this.type = type;
		this.cfg = cfg;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getV1() {
		return v1;
	}

	public void setV1(int v1) {
		this.v1 = v1;
	}

	public int getV2() {
		return v2;
	}

	public void setV2(int v2) {
		this.v2 = v2;
	}

	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCfg() {
		return cfg;
	}

	public void setCfg(String cfg) {
		this.cfg = cfg;
	}

    @Override
    public String toString() {
        return "ActionEntity{" +
                "id="+id+
                ",name='"+name+'\''+
                ",v1="+v1+
                ",v2="+v2+
                ",kid='"+kid+'\''+
                ",sid='"+sid+'\''+
                ",type="+type+
                ",cfg='"+cfg+'\''+
                '}';
    }
}
