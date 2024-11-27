// api.js file (ensure correct backend URL)
const API_URL = "http://localhost:8080/api";  // Correct backend URL

export async function createAccount(customerID, initialCredit) {
  const response = await fetch(`${API_URL}/create-account`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ customerID, initialCredit }),
  });

  if (!response.ok) {
    throw new Error("Failed to create account");
  }
}

export async function getUserInfo(customerID) {
  const response = await fetch(`${API_URL}/users/${customerID}`);
  if (!response.ok) {
    throw new Error("Failed to fetch user info");
  }

  return response.json();
}
