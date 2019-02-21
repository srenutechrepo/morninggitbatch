package com.sreenu.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sreenu.model.OrderBean;

/**
 * Servlet implementation class OrderHistoryDetails
 */
public class OrderHistoryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderHistoryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/xml");
		List<OrderBean> list = new ArrayList<OrderBean>();
		for (int i = 0; i <= 20; i++) {
			OrderBean bean = new OrderBean();
			bean.setOrderID("ORDERID" + i);
			bean.setAmount(new BigDecimal(10).multiply(new BigDecimal(i)));
			bean.setOrderName("ORDERNAME-" + i);
			bean.setStatus("success");
			list.add(bean);
		}
		StringBuilder xml = new StringBuilder();
		xml.append("<orders>");
		for (OrderBean entry : list) {
			xml.append("<order>");
			xml.append("<orderid>").append(entry.getOrderID())
					.append("</orderid>");
			xml.append("<ordername>").append(entry.getOrderName())
					.append("</ordername>");
			xml.append("<amount>").append(entry.getAmount())
					.append("</amount>");
			xml.append("<status>").append(entry.getStatus())
					.append("</status>");
			xml.append("</order>");
		}
		xml.append("</orders>");
		response.getWriter().println(xml.toString());
	}

}
