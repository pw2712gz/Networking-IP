package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {

	public static void main(String[] args) {
		try {
			// Obtain the IP address and hostname of the localhost
			InetAddress localhostAddress = InetAddress.getLocalHost();
			System.out.println("Localhost InetAddress: " + localhostAddress);
			System.out.println("Localhost host address: " + localhostAddress.getHostAddress());
			System.out.println("Localhost host name: " + localhostAddress.getHostName());
			System.out.println();

			// Get the InetAddress for a specific IP address
			InetAddress specificAddress = InetAddress.getByName("78.46.84.171");
			System.out.println("78.46.84.171 InetAddress: " + specificAddress);
			System.out.println();

			// Find the IP address of a domain name
			InetAddress googleAddress = InetAddress.getByName("google.com");
			System.out.println("Google InetAddress: " + googleAddress);
			System.out.println();

			// Get all IP addresses associated with a domain
			InetAddress[] googleAddresses = InetAddress.getAllByName("www.google.com");
			for (InetAddress address : googleAddresses) {
				System.out.println(address);
			}
			System.out.println();

			// Demonstrate reverse DNS lookup
			reverseDnsLookup("8.8.8.8");

		} catch (UnknownHostException e) {
			System.err.println("Host could not be resolved: " + e.getMessage());
		}
	}

	private static void reverseDnsLookup(String ipAddress) {
		try {
			InetAddress address = InetAddress.getByName(ipAddress);
			System.out.println("Reverse DNS lookup for " + ipAddress + ": " + address.getHostName());
		} catch (UnknownHostException e) {
			System.err.println("Error during reverse DNS lookup: " + e.getMessage());
		}
	}
}
