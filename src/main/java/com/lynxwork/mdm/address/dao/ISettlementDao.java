package com.lynxwork.mdm.address.dao;

import com.lynxwork.mdm.address.model.Settlement;

public interface ISettlementDao {
	public Settlement find(String name);
}
