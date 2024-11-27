// src/app/layout.js
import './globals.css'  // Import global CSS (e.g., Tailwind base styles)

export const metadata = {
  title: 'Account App',
  description: 'Frontend for the Account API with Next.js and Tailwind CSS',
}

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className="bg-gray-100 text-gray-900 font-sans">
        <header className="bg-blue-600 text-white p-4 shadow">
          <div className="container mx-auto">
            <h1 className="text-2xl font-bold">Account Management</h1>
          </div>
        </header>

        <main className="container mx-auto p-4 min-h-screen">
          {children}
        </main>

        <footer className="bg-gray-800 text-white p-4 mt-4">
          <div className="container mx-auto text-center">
            © 2024 Account Management App. All rights reserved.
          </div>
        </footer>
      </body>
    </html>
  )
}
