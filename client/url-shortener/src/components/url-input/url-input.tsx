import {useRef, useState} from "react";
import axios from 'axios';

export default function UrlInput() {

    const longUrlData: any = useRef(null);

    const [shortUrlData, setShortUrlData] = useState(null);

    const [shortUrlDetails, setShortUrlDetails] = useState({originalUrl: null, shortenUrl: null, urlHash: null, visits: 0});

    function shortenLongUrlHandler() {
        console.log(longUrlData?.current?.value);

        const headers = {
            'Content-Type': 'application/json',
        };

        axios.post('http://localhost:4000/api/short-url', {originalUrl: longUrlData?.current?.value}, {headers}).then(function (response) {
            setShortUrlData(response.data?.shortenUrl ? response.data?.shortenUrl : (response.data ? response.data : null));
            setShortUrlDetails((prevState) => ({
                ...prevState,
                originalUrl: response?.data?.originalUrl,
                shortenUrl: response?.data?.shortenUrl,
                urlHash: response?.data?.urlHash,
                visits: response?.data?.visits
            }));
        }).catch(function (error) {
           console.log(error)
        });
    }



    return (
        <main className="flex-1 flex flex-col items-center justify-center p-6">
            <div className="w-full max-w-xl">
                <div className="bg-white/10 backdrop-blur-md rounded-xl p-8 shadow-lg border border-white/10">
                    <div className="space-y-4">
                        <input
                            type="url"
                            ref={longUrlData}
                            name="url"
                            placeholder="Enter your URL here"
                            className="w-full px-4 py-3.5 rounded-lg bg-white/95 text-gray-800 placeholder-gray-500 focus:outline-none focus:ring-2 focus:ring-purple-400 transition-all"
                        />
                        <button type="button" className="w-full py-3.5 bg-indigo-500 hover:bg-indigo-600 text-white rounded-lg transition-colors font-medium shadow-md" onClick={shortenLongUrlHandler}>
                            Shorten URL
                        </button>
                    </div>

                    {shortUrlData && (
                        <div className="mt-6 p-4 bg-white/5 rounded-lg">
                        <span className="block">
                            Short URL: <a href={``+ shortUrlDetails.originalUrl} target="_blank"><b>{shortUrlData}</b></a>
                        </span>
                        </div>
                    )}

                </div>
            </div>
        </main>
    )
}