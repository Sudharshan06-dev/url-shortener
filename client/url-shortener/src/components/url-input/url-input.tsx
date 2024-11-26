export default function UrlInput() {
    return (
        <main className="flex-1 flex flex-col items-center justify-center p-6">
            <div className="w-full max-w-xl">
                <div className="bg-white/10 backdrop-blur-md rounded-xl p-8 shadow-lg border border-white/10">
                    <div className="space-y-4">
                        <input
                            type="url"
                            placeholder="Enter your URL here"
                            className="w-full px-4 py-3.5 rounded-lg bg-white/95 text-gray-800 placeholder-gray-500 focus:outline-none focus:ring-2 focus:ring-purple-400 transition-all"
                        />
                        <button
                            className="w-full py-3.5 bg-indigo-500 hover:bg-indigo-600 text-white rounded-lg transition-colors font-medium shadow-md"
                        >
                            Shorten URL
                        </button>
                    </div>
                </div>
            </div>
        </main>
    )
}