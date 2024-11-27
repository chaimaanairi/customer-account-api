"use client";

import { useState } from 'react';
import { createAccount, getUserInfo } from './api'; // Import the API helpers

export default function Home() {
  const [customerID, setCustomerID] = useState('');
  const [initialCredit, setInitialCredit] = useState('');
  const [userInfo, setUserInfo] = useState(null);
  const [error, setError] = useState('');

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');

    try {
      // Create the account
      await createAccount(customerID, initialCredit);
      
      // Fetch the user information
      const user = await getUserInfo(customerID);
      setUserInfo(user);
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div className="container mx-auto px-4 py-6">
      <h1 className="text-3xl font-bold text-center mb-4">Account Management</h1>

      <div className="max-w-md mx-auto bg-white p-6 rounded-lg shadow-lg">
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label htmlFor="customerID" className="block text-sm font-medium text-gray-700">
              Customer ID
            </label>
            <input
              type="text"
              id="customerID"
              value={customerID}
              onChange={(e) => setCustomerID(e.target.value)}
              className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            />
          </div>

          <div className="mb-4">
            <label htmlFor="initialCredit" className="block text-sm font-medium text-gray-700">
              Initial Credit
            </label>
            <input
              type="number"
              id="initialCredit"
              value={initialCredit}
              onChange={(e) => setInitialCredit(e.target.value)}
              className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            />
          </div>

          <button
            type="submit"
            className="w-full bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-600"
          >
            Create Account
          </button>
        </form>

        {error && (
          <div className="mt-4 text-red-500">
            <p>{error}</p>
          </div>
        )}
      </div>

      {userInfo && (
        <div className="mt-6 max-w-md mx-auto bg-white p-6 rounded-lg shadow-lg">
          <h2 className="text-xl font-bold text-center mb-4">User Information</h2>
          <div>
            <p><strong>Name:</strong> {userInfo.name} {userInfo.surname}</p>
            <p><strong>Balance:</strong> ${userInfo.balance}</p>
            <h3 className="mt-4 font-medium">Transactions:</h3>
            <ul>
              {userInfo.transactions && userInfo.transactions.length > 0 ? (
                userInfo.transactions.map((txn, index) => (
                  <li key={index}>
                    {txn.description} - ${txn.amount}
                  </li>
                ))
              ) : (
                <p>No transactions available.</p>
              )}
            </ul>
          </div>
        </div>
      )}
    </div>
  );
}
